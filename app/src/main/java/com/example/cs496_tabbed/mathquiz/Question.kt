package com.example.cs496_tabbed.mathquiz

import android.app.Activity

/**
 * Created by acer on 06-Apr-16.
 */
class Question : Activity {

    var iD = 0
    var qUESTION: String
    var oPTA: String
    var oPTB: String
    var oPTC: String
    var aNSWER: String

    constructor() {
        iD = 0
        qUESTION = ""
        oPTA = ""
        oPTB = ""
        oPTC = ""
        aNSWER = ""
    }

    constructor(qUESTION: String, oPTA: String, oPTB: String, oPTC: String,
                aNSWER: String) {
        this.qUESTION = qUESTION
        this.oPTA = oPTA
        this.oPTB = oPTB
        this.oPTC = oPTC
        this.aNSWER = aNSWER
    }
}