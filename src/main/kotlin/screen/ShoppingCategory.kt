package screen

import extensions.getNotEmptyString

class ShoppingCategory {

    fun showCategories() {
        val categories = arrayOf("패션", "전자기기", "반려동물용품")
        for (category in categories) {
            println(category)
        }

        println("=> if you want to go pocket input #")

        val selectedCategory = readLine().getNotEmptyString()
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