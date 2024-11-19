data class Product(
    val name: String,
    val price: Double,
    val quantity: Int
)

fun main() {
    val products = listOf(
        Product("Laptop", 999.99, 5),
        Product("Smartphone", 499.99, 10),
        Product("Tablet", 299.99, 0),
        Product("Smartwatch", 199.99, 3)
    )

    // Calculate the total inventory value
    val totalInventoryValue = products.sumOf { it.price * it.quantity }
    println("Total Inventory Value: $totalInventoryValue")

    // Find the most expensive product
    val mostExpensiveProduct = products.maxByOrNull { it.price }
    println("Most Expensive Product: ${mostExpensiveProduct?.name}")

    // Check if "Headphones" is in stock
    val hasHeadphones = products.any { it.name == "Headphones" }
    println("Headphones in stock: $hasHeadphones")

    // Sort products by price in descending order
    val productsSortedByPriceDesc = products.sortedByDescending { it.price }.map { it.name }
    println("Products sorted by price (descending): $productsSortedByPriceDesc")

    // Sort products by quantity in ascending order
    val productsSortedByQuantityAsc = products.sortedBy { it.quantity }.map { it.name }
    println("Products sorted by quantity (ascending): $productsSortedByQuantityAsc")
}
