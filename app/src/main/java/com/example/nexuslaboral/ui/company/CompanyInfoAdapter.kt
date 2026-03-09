package com.example.nexuslaboral.ui.company

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nexuslaboral.R

class CompanyInfoAdapter(
    private val items: List<CompanyInfo>
) : RecyclerView.Adapter<CompanyInfoAdapter.VH>() {

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvInfoTitle)
        val tvBullets: TextView = itemView.findViewById(R.id.tvInfoBullets)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_company_info, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        holder.tvTitle.text = item.title
        holder.tvBullets.text = item.bullets.joinToString("\n") { "• $it" }
    }

    override fun getItemCount(): Int = items.size
}