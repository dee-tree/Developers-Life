package com.sokolov.developerslive.contract


abstract class BaseContract {

    interface Presenter <V: View, M: Model> {
        var view: V?
        val model: M

        fun onViewAttached(v: V) {
            this.view = view
        }

        fun onViewDetached() {
            this.view = null
        }
    }

    interface View

    interface Model

}