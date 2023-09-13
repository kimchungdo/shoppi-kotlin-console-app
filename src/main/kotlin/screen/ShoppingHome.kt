package screen

class ShoppingHome {

    fun start(){

        showWelcomeMessage()

        showCategories()
    }
    private fun showWelcomeMessage() {
        println("hello, welcome to my application")
        println("if you want to continue, please input your name")
        val name = readLine()
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