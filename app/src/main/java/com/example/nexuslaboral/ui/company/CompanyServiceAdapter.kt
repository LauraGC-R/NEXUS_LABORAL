package com.example.nexuslaboral.ui.company

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nexuslaboral.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.chip.Chip

class CompanyServiceAdapter(
    private val items: List<CompanyService>,
    private val onWatch: (CompanyService) -> Unit
) : RecyclerView.Adapter<CompanyServiceAdapter.VH>() {

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvServiceTitle)
        val chipTag: Chip = itemView.findViewById(R.id.chipServiceTag)
        val tvDesc: TextView = itemView.findViewById(R.id.tvServiceDesc)
        val pb: ProgressBar = itemView.findViewById(R.id.pbService)
        val tvMeta: TextView = itemView.findViewById(R.id.tvServiceMeta)
        val btnWatch: MaterialButton = itemView.findViewById(R.id.btnWatch)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_company_service, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        holder.tvTitle.text = item.title
        holder.chipTag.text = item.tag
        holder.tvDesc.text = item.desc
        holder.pb.progress = item.progress
        holder.tvMeta.text = "${item.minutes} min"

        holder.btnWatch.setOnClickListener { onWatch(item) }
        holder.itemView.setOnClickListener { onWatch(item) }
    }

    override fun getItemCount(): Int = items.size
}