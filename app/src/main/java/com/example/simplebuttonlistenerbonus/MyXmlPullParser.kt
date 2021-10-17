package com.example.simplebuttonlistenerbonus

import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream

class MyXmlPullParserHandler {
    private val games : String? = null
    private var text: String =""
    private var gameName = ""

    fun parse(inputStream: InputStream): String {
//        try {
            val factory = XmlPullParserFactory.newInstance()
            val parser = factory.newPullParser()
            parser.setInput(inputStream, null)
        var eventType = parser.eventType
        while (eventType != XmlPullParser.END_DOCUMENT) {
            val tagName = parser.name

            when (eventType) {
                XmlPullParser.TEXT -> text = parser.text
                XmlPullParser.END_TAG -> when {
                            tagName.equals ("Name", ignoreCase = true) -> {
                        gameName = text
                    }
                }

            }
            eventType = parser.next()
        }
        return gameName
    }
}