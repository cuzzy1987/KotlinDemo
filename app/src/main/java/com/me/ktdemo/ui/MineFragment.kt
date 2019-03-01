package com.me.ktdemo.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.me.ktdemo.R
import kotlinx.android.synthetic.main.fragment_mine.*
import kotlinx.android.synthetic.main.item_property_mine_layout.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MineFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_mine, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
    }

    private fun initView() {
        val view: View = layoutInflater.inflate(R.layout.item_property_mine_layout,null)
        view.leftTv.text = "属性"
        view.rightTv.text = "属性值"
        containerLl.addView(view)
        val view2: View = layoutInflater.inflate(R.layout.item_property_mine_layout,null)
        view2.leftTv.text = "属性2"
        view2.rightTv.text = "属性值2"
        containerLl.addView(view2)
    }

}
