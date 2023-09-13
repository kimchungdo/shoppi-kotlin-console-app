package screen

import LINE_DIVIDER
import extensions.getNotEmptyString

class ShoppingHome : Screen() {

    fun start(){

        showWelcomeMessage()

        showCategories()
    }
    private fun showWelcomeMessage() {
        ScreenStack.push(this)
        println("hello, welcome to my application")
        println("if you want to continue, please input your name")
        val name = readLine().getNotEmptyString()
        println(
            """
            hello $name
            pleaze input your category in wish
            $LINE_DIVIDER
            """.trimIndent()
        )
    }

    private fun showCategories(){
        val shoppingCategory = ShoppingCategory()
        shoppingCategory.showCategories()
    }

}