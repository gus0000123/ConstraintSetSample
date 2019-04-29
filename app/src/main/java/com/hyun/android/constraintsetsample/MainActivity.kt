package com.hyun.android.constraintsetsample

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.util.Log
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.BounceInterpolator
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var isopen = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_add.setOnClickListener {
            if (isopen) {
                updateView(R.layout.activity_main_alt)
                btn_add.text = "+"
                tv_contents.text = "2019-04-26 15:57 합정동에서 작성"

            } else {
                updateView(R.layout.activity_main)
                btn_add.text = "+ 할일 추가"
                tv_contents.text = "할일 목록을 입력하세요"
            }
            isopen = !isopen
        }
    }

    fun updateView(@LayoutRes id: Int) {
        var targetConstSet = ConstraintSet()
        targetConstSet.clone(this, id)
        targetConstSet.applyTo(root)

        val trans = ChangeBounds()
        trans.interpolator = AccelerateInterpolator()
        TransitionManager.beginDelayedTransition(root, trans)
    }
}
