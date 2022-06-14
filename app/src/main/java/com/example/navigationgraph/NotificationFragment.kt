package com.example.navigationgraph

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.navigationgraph.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment() {
    private var _binding: FragmentNotificationBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val notificationViewModel = ViewModelProvider(this).get(NotificationViewModel::class.java)

        _binding = FragmentNotificationBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotification

        notificationViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}