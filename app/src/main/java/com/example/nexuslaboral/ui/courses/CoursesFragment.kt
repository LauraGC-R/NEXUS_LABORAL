package com.example.nexuslaboral.ui.courses

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.nexuslaboral.R
import com.example.nexuslaboral.databinding.FragmentCoursesBinding

class CoursesFragment : Fragment(R.layout.fragment_courses) {

    private var _binding: FragmentCoursesBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCoursesBinding.bind(view)

        // Aquí luego metemos acciones de cursos
        // Ejemplo:
        // binding.cardCurso1.setOnClickListener { ... }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}