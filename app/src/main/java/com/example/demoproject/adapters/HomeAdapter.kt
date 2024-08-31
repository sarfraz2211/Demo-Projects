package com.example.demoproject.adapters


import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.demoproject.R

class HomeAdapter(
    private val items: List<String>,
    private val onItemClick: (String) -> Unit,
    private val isHorizontal: Boolean
) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    companion object {
        const val TYPE_HORIZONTAL = 0
        const val TYPE_VERTICAL = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (isHorizontal) TYPE_HORIZONTAL else TYPE_VERTICAL
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val layoutRes = if (viewType == TYPE_HORIZONTAL) R.layout.item_card else R.layout.card_item_2
        val view = LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cardView: CardView = itemView.findViewById(R.id.cardViews)
        private val textView: TextView = itemView.findViewById(R.id.textViewItems)
        private val txtStep:TextView = itemView.findViewById(R.id.txtStep)
        // Full text


        fun bind(item: String) {
            textView.text = item
            cardView.setOnClickListener { onItemClick(item) }

            val fullText = "Step Into Tomorrow: Exploring Special Computing Impact On Industries and the metaverse."
            val spannable = SpannableStringBuilder(fullText)

// Set the bold style from index 0 to the length of "Step Into Tomorrow:"
            spannable.setSpan(
                StyleSpan(Typeface.BOLD), // Apply bold style
                0, // Start index of bold text
                20, // End index of bold text
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            txtStep.text = spannable
        }
    }
}


