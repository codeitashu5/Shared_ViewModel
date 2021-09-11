package com.example.cupcake.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {
    //adding the data

    //quantity
    private val _quantity = MutableLiveData<Int>(0)
    val quantity : LiveData<Int> get() = _quantity
    //flavour
    private val _flavour = MutableLiveData<String>("")
    val flavour:LiveData<String> get() = _flavour
    //pickup date
    private val _date = MutableLiveData<String>("")
    val date : LiveData<String> get() = _date
    //price
    private val _price = MutableLiveData<Double>(0.0)
    val price : LiveData<Double> get() = _price


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


    fun hasDefaultFlavour():Boolean{
        return _flavour.value.isNullOrEmpty()
    }

}