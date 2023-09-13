package screen

import extensions.getNotEmptyString

class ShoppingCategory : Screen() {

    fun showCategories() {
        ScreenStack.push(this)
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
                val shoppingProductList = ShoppingProductList(selectedCategory)
                shoppingProductList.showProducts()
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