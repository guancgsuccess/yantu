
function ChackText() {

}

//选择定制的方式
function changeVisitor(method) {
    var methodId = method.id;
    var footStyle = document.getElementById("footer");
    if(methodId == "cus-select-private"){
        method.className = "cus-select cur";
        document.getElementById("cus-select-company").className="cus-select";
        $("#companyName").hide();
        $("#list-companyName").hide();
        footStyle.style.marginTop = "-25px";
    }
    if(methodId == "cus-select-company"){
        method.className = "cus-select cur";
        document.getElementById("cus-select-private").className="cus-select";
        $("#companyName").show();
        $("#list-companyName").show();
        footStyle.style.marginTop = "35px";
    }
    document.getElementById("list-methodName").innerText=document.getElementById(methodId).innerText;
    $("#list-methodName-em").show();
}

//用户输入文本  出发地 目的地 联系人 联系电话 公司名
function userInput(element) {
    var elementId = element.id;

    //出发地
    if(elementId == "placeOfDeparture"){
        var placeOfDepartureValue = document.getElementById("placeOfDeparture").value;
        document.getElementById("list-placeOfDeparture").innerText=placeOfDepartureValue;
        $("#list-placeOfDeparture-em").show();
        $("#error-tip-placeOfDeparture").hide();
        if (placeOfDepartureValue === "" || placeOfDepartureValue == null){
            $("#list-placeOfDeparture-em").hide();
            $("#error-tip-placeOfDeparture").show();
        }
    }
    //目的地
    if(elementId == "destination"){
        var destinationValue = document.getElementById("destination").value;
        document.getElementById("list-destination").innerText=destinationValue;
        $("#list-destination-em").show();
        $("#error-tip-destination").hide();
        if (destinationValue === "" || destinationValue == null){
            $("#list-destination-em").hide();
            $("#error-tip-destination").show();
        }
    }
    //出发时间
    if(elementId == "departureDate"){
        var departureDateValue = document.getElementById("departureDate").value;
        document.getElementById("list-departureDate").innerText=departureDateValue;
        $("#list-departureDate-em").show();
        $("#error-tip-departureDate").hide();
        if (departureDateValue === "" || departureDateValue == null){
            $("#list-departureDate-em").hide();
            $("#error-tip-departureDate").show();
        }
    }

    //联系人
    if(elementId == "linkman"){
        var linkmanValue = document.getElementById("linkman").value;
        document.getElementById("list-linkman").innerText=document.getElementById("linkman").value;
        $("#list-linkman-em").show();
        $("#error-tip-linkman").hide();
        if (linkmanValue === "" || linkmanValue == null){
            $("#list-linkman-em").hide();
            $("#error-tip-linkman").show();
        }
    }

    //联系电话
    if(elementId == "linkPhone"){
        var linkPhoneValue = document.getElementById("linkPhone").value;
        document.getElementById("list-linkPhone").innerText=linkPhoneValue;
        $("#list-linkPhone-em").show();
        $("#error-tip-linkPhone").hide();
        if (linkPhoneValue ==="" || linkPhoneValue == null){
            $("#list-linkPhone-em").hide();
            $("#error-tip-linkPhone").show();
        }
    }

    //公司名
    if(elementId == "nameOfCompany"){
        var nameOfCompanyValue = document.getElementById("nameOfCompany").value;
        document.getElementById("list-nameOfCompany").innerText=nameOfCompanyValue;
        $("#list-nameOfCompany-em").show();
        $("#error-tip-nameOfCompany").hide();
        if (nameOfCompanyValue ==="" || nameOfCompanyValue == null){
            $("#list-nameOfCompany-em").hide();
            $("#error-tip-nameOfCompany").show();
        }
    }


}

//右边列表获取出发时间信息
// function changeDepartureDate() {
//     document.getElementById("list-departureDate").innerText = document.getElementById("departureDate").value;
//     $("#list-departureDate-em").show();
// }

//加减法
function ChangeNumber(click) {
    var count = click.id;

    var dayNumber = document.getElementById("dataNumber").value;
    //减少出游天数
    if(count == "subDay"){
        if(dayNumber >=1){
            var newDayNumber = --dayNumber;
            document.getElementById("dataNumber").value = newDayNumber;
        }else{
            alert("已是最小天数, 不能进行操作");
        }
    }
    //添加出游天数
    if(count == "addDay"){
        var newDayNumber = ++dayNumber;
        document.getElementById("dataNumber").value = newDayNumber;
    }
    document.getElementById("list-dataNumber").innerText = document.getElementById("dataNumber").value;

    var adultNumber = document.getElementById("adultNumber").value;
    //减少成年人数量
    if(count == "subAdultNumber"){
        if(adultNumber >=1){
            var newAdultNumber = --adultNumber;
            document.getElementById("adultNumber").value = newAdultNumber;
        }else{
            alert("已是最小成人数, 不能进行操作");
        }
    }
    //添加成年人数量
    if(count == "addAdultNumber"){
        var newAdultNumber = ++adultNumber;
        document.getElementById("adultNumber").value = newAdultNumber;
    }

    var kitNumber = document.getElementById("kidNumber").value;
    //减少儿童数量
    if(count == "subKitNumber"){
        if(kitNumber >=1){
            var newKitNumber = --kitNumber;
            document.getElementById("kidNumber").value = newKitNumber;
        }else{
            alert("已是最小成人数, 不能进行操作");
        }
    }
    //添加儿童数量
    if(count == "addKitNUmber"){
        var newKitNumber = ++kitNumber;
        document.getElementById("kidNumber").value = newKitNumber;
    }
    var number1 = document.getElementById("adultNumber").value;
    var number2 = document.getElementById("kidNumber").value;
    document.getElementById("list-personNumber").innerText = parseInt(number1)+parseInt(number2);
}

// //修改出游时长
// function ChangeDataNumber() {
//     document.getElementById("list-dataNumber").innerText = document.getElementById("dataNumber").value;
//
// }



//选择人均价格
function changePrice(price) {
    document.getElementById("cus-select-1").className = "cus-select";
    document.getElementById("cus-select-500").className = "cus-select";
    document.getElementById("cus-select-1000").className = "cus-select";
    document.getElementById("cus-select-5000").className = "cus-select";
    document.getElementById("cus-select-10000").className = "cus-select";
    document.getElementById("cus-select-15000").className = "cus-select";
    document.getElementById("cus-select-20000").className = "cus-select";
    document.getElementById("cus-select-none").className = "cus-select";
    //将选中的价格的className改为cus-select cur
    var priceId = price.id;
    price.className = "cus-select cur";
    document.getElementById("list-priceId").innerText=document.getElementById(priceId).innerText;
}



