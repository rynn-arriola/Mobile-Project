package com.example.mobileapplicationproject.adapter.viewholder

import android.telephony.PhoneNumberUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.mobileapplicationproject.R
import com.example.mobileapplicationproject.databinding.ListitemEmployeeBinding
import com.example.mobileapplicationproject.model.response.Employee

class EmployeeViewHolder(
    private val viewBinding: ListitemEmployeeBinding
): RecyclerView.ViewHolder(viewBinding.root) {
    fun onBind(model: Employee) {

        viewBinding.tvFullName.text = model.full_name
        viewBinding.tvPhoneNumber.text = PhoneNumberUtils.formatNumber(model.phone_number)
        viewBinding.tvEmail.text = model.email_address
        viewBinding.tvType.text = model.employee_type
        viewBinding.tvTeam.text = model.team
        viewBinding.tvBio.text = model.biography

        // line #30 cache the images it loads
        //  line #29 will create a place holder for the image so the UI won't look bad if image failed to load.
        Glide.with(itemView)
            .load(model.photo_url_large)
            .placeholder(R.drawable.ic_launcher_background)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(viewBinding.ivImage)
    }
    companion object {
        fun newInstance(parent: ViewGroup) = ListitemEmployeeBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ).let { binding -> EmployeeViewHolder(binding) }
    }
}