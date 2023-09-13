package screen

class ShoppingCategory {

    fun showCategories() {
        val categories = arrayOf("패션", "전자기기", "반려동물용품")
        for (category in categories) {
            println(category)
        }

        println("=> if you want to go pocket input #")

        var selectedCategory = readLine()
        while (selectedCategory.isNullOrBlank()) {
            println("please input value")
            selectedCategory = readLine()
        }

        if (selectedCategory == "#") {
            val shoppingCart = ShoppingCart()
            shoppingCart.showCartItems()
        } else {

            if(categories.contains(selectedCategory)){
                val shoppingProductList = ShoppingProductList()
                shoppingProductList.showProducts(selectedCategory)
            }else{
                showErrorMessage(selectedCategory)
            }

        }
    }

    private fun showErrorMessage(selectedCategory: String?) {
        println("[$selectedCategory] : not existed please retry")
        showCategories()
    }

}