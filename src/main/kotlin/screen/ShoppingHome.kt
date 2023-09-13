package screen

import extensions.getNotEmptyString

class ShoppingHome {

    fun start(){

        showWelcomeMessage()

        showCategories()
    }
    private fun showWelcomeMessage() {
        println("hello, welcome to my application")
        println("if you want to continue, please input your name")
        val name = readLine().getNotEmptyString()
        println(
            """
            hello $name
            pleaze input your category in wish
            ***==========================
            """.trimIndent()
        )
    }

    private fun showCategories(){
        val shoppingCategory = ShoppingCategory()
        shoppingCategory.showCategories()
    }

}