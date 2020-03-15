package com.fortnightfellows.granny.ui.fragments

import android.animation.ObjectAnimator
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.fortnightfellows.granny.R
import com.fortnightfellows.granny.adapters.IngredientsRecyclerAdapter
import com.fortnightfellows.granny.adapters.PointsRecyclerAdapter
import com.fortnightfellows.granny.animations.RecyclerAnimations.collapse
import com.fortnightfellows.granny.animations.RecyclerAnimations.expand
import com.fortnightfellows.granny.api_wrapper.models.Ingredient
import com.fortnightfellows.granny.api_wrapper.models.Point
import com.fortnightfellows.granny.databinding.RecipeFragmentBinding
import com.fortnightfellows.granny.utils.Display.pxFromDp
import com.fortnightfellows.granny.view_models.RecipeFragmentViewModel

class RecipeFragment : Fragment() {

    private lateinit var binding: RecipeFragmentBinding
    private lateinit var viewModel: RecipeFragmentViewModel

    private lateinit var amountSpinnerAdapter: ArrayAdapter<Int>
    private lateinit var ingredientsRecyclerAdapter: IngredientsRecyclerAdapter
    private lateinit var pointsRecyclerAdapter: PointsRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.recipe_fragment, container, false)
        viewModel = RecipeFragmentViewModel()
        binding.model = viewModel
        amountSpinnerAdapter = ArrayAdapter(context!!, R.layout.spinner_item,
            listOf(1, 2, 3, 4, 5))
        ingredientsRecyclerAdapter = IngredientsRecyclerAdapter(
            context!!,
            listOf(
                Ingredient("Кот", "1"),
                Ingredient("Вода", "1"),
                Ingredient("Бандаж", "1"),
                Ingredient("Сила", "10")
            ))
        pointsRecyclerAdapter = PointsRecyclerAdapter(
            context!!,
            listOf(
                Point("1. Жёстко связать кота, забарикадировав двери"),
                Point("2. Налить всю воду в тазик размера, соответствующего вашему ЭГО"),
                Point("3. Добавить в тазик немного кота, потом ещё немного и далее до полного погружения"),
                Point("4. Наслаждаться, тем что вы злой и красивый")
            )
        )
        binding.spinner.adapter = amountSpinnerAdapter
        binding.recyclerIngredients.adapter = ingredientsRecyclerAdapter
        binding.recyclerPoints.adapter = pointsRecyclerAdapter
        binding.paneExpand.setOnClickListener {
            if (binding.recyclerIngredients.visibility == GONE) {
                val btnAnimation = ObjectAnimator.ofFloat(
                    binding.btnExpand, "rotation", 180f, 0f
                )
                btnAnimation.duration = 500
                btnAnimation.start()
                expand(
                    binding.recyclerIngredients,
                    ingredientsRecyclerAdapter.itemCount * pxFromDp(context!!, 64),
                    500
                )
            } else {
                val btnAnimation = ObjectAnimator.ofFloat(
                    binding.btnExpand, "rotation", 0f, 180f
                )
                btnAnimation.duration = 500
                btnAnimation.start()
                collapse(binding.recyclerIngredients, 500, 0)
            }
        }
        return binding.root
    }
}
