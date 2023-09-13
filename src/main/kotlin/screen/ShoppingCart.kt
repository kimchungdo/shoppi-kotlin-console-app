package screen

import data.CartItems

class ShoppingCart {
    private val products = CartItems.products
    fun showCartItems(){
        if(products.isNotEmpty()){
            println(
                products.keys.joinToString(
                    separator = ", \n",
                    prefix = """
                        ***==========================
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
