package com.peejweej.ezandroidtransitionanimations

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment

enum class TransitionAnimationOption {
    VERTICAL, HORIZONTAL, CROSS_FADE;
    
    val startEnterAnimation get() = when(this) {
        VERTICAL   -> R.anim.enter_from_bottom
        HORIZONTAL -> R.anim.enter_from_right
        CROSS_FADE -> R.anim.enter_center
    }
    
    val startExitAnimation get() = when(this) {
        VERTICAL   -> R.anim.enter_center
        HORIZONTAL -> R.anim.enter_center
        CROSS_FADE -> R.anim.exit_fade
    }
    
    val finishEnterAnimation get() = when(this) {
        VERTICAL   -> R.anim.enter_center
        HORIZONTAL -> R.anim.enter_center
        CROSS_FADE -> R.anim.enter_center
    }
    
    val finishExitAnimation get() = when(this) {
        VERTICAL   -> R.anim.exit_on_bottom
        HORIZONTAL -> R.anim.exit_on_right
        CROSS_FADE -> R.anim.exit_fade
    }
}

fun Activity.startActivity(intent: Intent, animationOption: TransitionAnimationOption, bundle: Bundle? = null) {
    startActivity(intent, bundle)
    overridePendingTransition(animationOption.startEnterAnimation, animationOption.startExitAnimation)
}

fun Activity.startActivity(intent: Intent, requestCode: Int, animationOption: TransitionAnimationOption, bundle: Bundle? = null) {
    startActivityForResult(intent, requestCode, bundle)
    overridePendingTransition(animationOption.startEnterAnimation, animationOption.startExitAnimation)
}

fun Fragment.startActivity(intent: Intent, animationOption: TransitionAnimationOption, bundle: Bundle? = null) {
    startActivity(intent, bundle)
    activity?.overridePendingTransition(animationOption.startEnterAnimation, animationOption.startExitAnimation)
}

fun Fragment.startActivity(intent: Intent, requestCode: Int, animationOption: TransitionAnimationOption, bundle: Bundle? = null) {
    startActivityForResult(intent, requestCode, bundle)
    activity?.overridePendingTransition(animationOption.startEnterAnimation, animationOption.startExitAnimation)
}

fun Activity.finish(animationOption: TransitionAnimationOption, requestCode: Int? = null) {
    if(requestCode != null) {
        finishActivity(requestCode)
    }
    else {
        finish()
    }
    overridePendingTransition(animationOption.finishEnterAnimation, animationOption.finishExitAnimation)
}