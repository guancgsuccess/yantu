function clickShow(click) {
    var clickId = click.id;
    if(click == "icon-caret-down-sales"){
        $("#_j_sales_panel").show();
    }
    if(click == "icon-caret-down-hotel"){
        $("#_j_community_panel").show();
    }
}

function searchButton() {
    var keyword = document.getElementById("keyword").value;
    if(keyword === ""){
        document.getElementById("keyword").placeholder ="您还没有输入任何信息!";
    }else {
        //判断数据库是否存在
        if (window.XMLHttpRequest) {
            xhr = new XMLHttpRequest();
        } else {
            xhr = new ActiveXObject('Microsoft.XMLHTTP');
        }
        var keywordObj = {
            keyword : keyword
        }
        var keywordJson = JSON.stringify(keywordObj);
        xhr.open("POST", "/yantu/scenic/getScenicByName", true);
        xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");
        xhr.send(keywordJson);
        xhr.onreadystatechange = function () {
            if(xhr.readyState === 4 && xhr.status === 200) {
                var result = JSON.parse(xhr.responseText);
                console.log(result);
                if(result.status === 1){
                    window.location.href = "/scenicDetail/"+result.data.scenicId;
                }else{
                    document.getElementById("keyword").value = null;
                    document.getElementById("keyword").placeholder ="找不到想要搜索的目标,点击重新输入!";
                }

            }

        }
    }


}

function changeImage(image) {
    document.getElementById("show-nav-1").className = "";
    document.getElementById("show-nav-2").className = "";
    document.getElementById("show-nav-3").className = "";
    document.getElementById("show-nav-4").className = "";
    document.getElementById("show-nav-5").className = "";

    var imageId = image.id;
    document.getElementById(imageId).className = "active";
    document.getElementById("main-image").src = image.firstChild.src;
}

// 定时器 --- 自动播放
var timer = null;
var i=0;
function autoPlay(objli) {
    if(i===5){
        i=0;
    }
    document.getElementById("show-nav-1").className = "";
    document.getElementById("show-nav-2").className = "";
    document.getElementById("show-nav-3").className = "";
    document.getElementById("show-nav-4").className = "";
    document.getElementById("show-nav-5").className = "";
    objli[i].className = "active";
    document.getElementById("main-image").src = objli[i].getElementsByTagName("img")[0].src;
    i++;
    timer=setTimeout(function() {
        autoPlay(objli)
    }, 5000)
}


