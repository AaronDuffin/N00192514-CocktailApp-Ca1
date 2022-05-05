package com.example.cocktailsapps.data

import android.os.Parcel
import java.util.*
import android.os.Parcelable

class CocktailEntity(
    // Note in this version of my code I've changed the attributes so they match up with the JSON data.
    var idDrink: Int,
    var strDrink: String?,
    var strCategory: String?,
    var strInstructions: String?,
) : Parcelable
{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    // Don't think I need this constructor....no arguments constructor - if no values are passed in this one is executed.
    // constructor() : this(NEW_PLANT_ID, "", "", "", 0.0)
    // New Plant - this constructor is called when there is a name, date and description, but no plant ID yet
    // constructor(name: String, date: Date, description: String) : this(NEW_PLANT_ID, name, description)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(idDrink)
        parcel.writeString(strDrink)
        parcel.writeString(strCategory)
        parcel.writeString(strInstructions)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CocktailEntity> {
        override fun createFromParcel(parcel: Parcel): CocktailEntity {
            return CocktailEntity(parcel)
        }

        override fun newArray(size: Int): Array<CocktailEntity?> {
            return arrayOfNulls(size)
        }
    }
}