package com.example.cupcake.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*
import javax.xml.datatype.DatatypeConstants.TIME

class OrderViewModel : ViewModel() {
    //adding the data

    //quantity
    private val _quantity = MutableLiveData<Int>()
    val quantity : LiveData<Int> get() = _quantity
    //flavour
    private val _flavour = MutableLiveData<String>()
    val flavour:LiveData<String> get() = _flavour
    //pickup date
    private val _date = MutableLiveData<String>()
    val date : LiveData<String> get() = _date
    //price
    private val _price = MutableLiveData<Double>()
    val price : LiveData<Double> get() = _price

    //create property to hold all dates
    val dateOptions = pickUpDates()


    init {
        resetOrder()
    }

    //creating the setter fun
    fun setQuantity(numberCupcakes:Int){
        _quantity.value = numberCupcakes
    }
    fun setFlavour(desiredFlavour:String){
        _flavour.value = desiredFlavour
    }
    fun setPickUpDate(pickUpDate:String){
        _date.value = pickUpDate
    }

    //function to find if flavour exist in the value or not
    fun hasDefaultFlavour():Boolean{
        return _flavour.value.isNullOrEmpty()
    }

    //function to reset order

    fun resetOrder(){
        _date.value = dateOptions[0]
        _flavour.value = ""
        _quantity.value = 0
        _price.value = 0.0
    }

    //function to return pickup dates

    fun pickUpDates():MutableList<String>{
        val options = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        //It will give you the current date
        val calendar = Calendar.getInstance()
        //adding 4 dates to the list
        repeat(4) {
            options.add(formatter.format(calendar.time))
            //increasing date by one
            calendar.add(Calendar.DATE, 1)
        }
        return options
    }



}