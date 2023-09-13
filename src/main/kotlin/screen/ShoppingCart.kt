package screen

import LINE_DIVIDER
import data.CartItems
import extensions.getNotEmptyString

class ShoppingCart : Screen(){
    private val products = CartItems.products
    fun showCartItems(){
        ScreenStack.push(this)
        if(products.isNotEmpty()){
            println(
                products.keys.joinToString(
                    separator = ", \n",
                    prefix = """
                        $LINE_DIVIDER
                        your shopping cart item list here
                        
                    """.trimIndent()
                ) {product ->
                    "category : ${product.categoryLabel} / item: ${product.name} / amount: ${products[product]}"
                }
            )
        } else {
            println("""
                no Items.
            """.trimIndent())
        }
        showPreviousScreenOption()
    }

    private fun showPreviousScreenOption() {
        println(
            """
                $LINE_DIVIDER
                go back to previous Page? (y/n)
            """.trimIndent()
        )
        when(readLine().getNotEmptyString()){
            "y"->{
                moveToPreviousScreen()
            }
            "n"->{
                showCartItems()
            }
            else->{
                //TODO reinput request
            }
        }
    }

    private fun moveToPreviousScreen() {
        ScreenStack.pop()
        when(val previousScreen = ScreenStack.peek()){
            is ShoppingCategory -> {
                previousScreen.showCategories()
            }
            is ShoppingProductList ->{
                previousScreen.showProducts()
            }
            is ShoppingCart, is ShoppingHome -> {
                //do nothing
            }
            else ->{
                //do nothing
            }
        }

    }
}
