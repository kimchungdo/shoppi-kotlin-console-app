package screen

import LINE_DIVIDER
import data.CartItems
import data.Product
import extensions.getNotEmptyInt
import extensions.getNotEmptyString

class ShoppingProductList(private val selectedCategory: String) : Screen() {
    private val products = arrayOf(
        Product("패션", "겨울 패딩"),
        Product("패션", "겨울 바지"),
        Product("전자기기", "핸드폰"),
        Product("전자기기", "블루투스 이어폰"),
        Product("전자기기", "노트북"),
        Product("반려동물용품", "건식사료"),
        Product("반려동물용품", "습식사료"),
        Product("반려동물용품", "치약"),
        Product("반려동물용품", "간식")
    )
    private val categories: Map<String, List<Product>> = products.groupBy{product->
        product.categoryLabel
    }

    fun showProducts(){
        ScreenStack.push(this)
        val categoryProducts = categories[selectedCategory]
        if(!categoryProducts.isNullOrEmpty()){
            println("""
                $LINE_DIVIDER
                your choice is [$selectedCategory]. 
            """.trimIndent())
            categoryProducts.forEachIndexed{index, product->
                println("${index}. ${product.name}")
            }
            showCartOption(categoryProducts)
        }else{
            showEmptyProductMessage(selectedCategory)
        }
    }

    private fun showCartOption(categoryProducts: List<Product>) {
        println("""
            **===================================
            input number of item which to add in shopping cart
        """.trimIndent())

        val selectedIndex = readLine().getNotEmptyInt()
        categoryProducts.getOrNull(selectedIndex)?.let{product->
            CartItems.addProduct(product)
            println("=> to move to ShoppingCart, input # else input *")
            var answer = readLine().getNotEmptyString()
            if(answer == "#"){
                val shoppingCart = ShoppingCart()
                shoppingCart.showCartItems()
            }else if (answer == "*"){
                showProducts()
            }else{
                // TODO : other
            }
        } ?: kotlin.run{
            println("$selectedIndex => not found. please re-input")
            showProducts()
        }
    }

    private fun showEmptyProductMessage(selectedCategory: String){
        println("[${selectedCategory}] category product Not Found")
    }
}