package screen

import LINE_DIVIDER
import data.CartItems

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
    }
}
