package com.example.fitplate_dienams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecipeFragment : Fragment() {

    private var category: String? = null

    companion object {
        private const val ARG_CATEGORY = "category"

        fun newInstance(category: String): RecipeFragment {
            val fragment = RecipeFragment()
            val bundle = Bundle().apply {
                putString(ARG_CATEGORY, category)
            }
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        category = arguments?.getString(ARG_CATEGORY)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.recipe_guide, container, false)

        // Configure RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = RecipeAdapter(getRecipesForCategory())

        return view
    }

    private fun getRecipesForCategory(): List<Recipe> {
        // Return recipes based on the category
        return when (category) {
            "Breakfast" -> listOf(
                Recipe("Overnight Oats dengan Chia dan Buah-Buahan", "15 menit", R.drawable.salad),
                Recipe("Pancake Protein dengan Pisang", "15 menit", R.drawable.salad),
                Recipe("Toast Alpukat dengan Telur Rebus", "15 menit", R.drawable.salad),
                Recipe("Omelet Sayur dan Avokad", "20 menit", R.drawable.omelet_sayur),
                Recipe("Smoothie Bowl Protein Tinggi", "20 menit", R.drawable.smoothie_bowl)
            )
            "Lunch" -> listOf(
                Recipe("Salad Ayam Panggang dengan Quinoa dan Sayuran", "15 menit", R.drawable.salad_ayam_panggang),
                Recipe("Tumis Tofu dengan Brokoli dan Kacang Almond", "15 menit", R.drawable.salmon_panggang),
                Recipe("Sup Ayam Sayuran", "15 menit", R.drawable.salad),
                Recipe("Nasi Cauliflower (Kembang Kol) dengan Daging Sapi dan Sayuran", "15 menit", R.drawable.salad),
                Recipe("Sup Sayuran dengan Tempe dan Miso", "15 menit", R.drawable.salad)
            )
            "Dinner" -> listOf(
                Recipe("Salmon Panggang dengan Sayuran Kukus", "15 menit", R.drawable.salad),
                Recipe("Zucchini Noodles dengan Daging Sapi Tumis", "15 menit", R.drawable.salad),
                Recipe("Sup Ayam Sayuran", "15 menit", R.drawable.salad),
                Recipe("Tofu dan Brokoli Tumis dengan Saus Kedelai", "15 menit", R.drawable.salad),
                Recipe("Ayam Panggang dengan Salad Avokad dan Tomat", "15 menit", R.drawable.salad)
            )
            "Snack" -> listOf(
                Recipe("Energy Balls Coklat dan Almond", "15 menit", R.drawable.salad),
                Recipe("Smoothie Bowl Pisang dan Berry", "15 menit", R.drawable.salad),
                Recipe("Keripik Kale Panggang", "15 menit", R.drawable.salad),
                Recipe("Greek Yogurt dengan Madu dan Kacang-Kacangan", "15 menit", R.drawable.salad),
                Recipe("Edamame Rebus dengan Garam Laut", "15 menit", R.drawable.salad)

            )
            else -> emptyList()
        }
    }
}
