package com.example.mushroommart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_product.view.*

class ProductAdapter(
    private val products: List<Product>,
    private val onAddToCart: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false))

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) =
        holder.bind(products[position], onAddToCart)

    override fun getItemCount() = products.size

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product, onAddToCart: (Product) -> Unit) {
            itemView.tvProductName.text = product.name
            itemView.tvProductDescription.text = product.description
            itemView.tvProductPrice.text = "₹${product.price}"
            Picasso.get().load(product.imageUrl).into(itemView.ivProductImage)
            itemView.btnAddToCart.setOnClickListener { onAddToCart(product) }
        }
    }
}