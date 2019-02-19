
function search() {
    var input = $("#search").val();
    if(input == ""){
        $("#list_group").remove();
        return;
    }
    $.ajax({
        url: "/search",
        data: "input=" + input,
        success: function (users) {
            $("#list_group").remove();
            var list_group = document.createElement("div");
            list_group.className = "list-group";
            list_group.id = "list_group";

            for (var i = 0; i < users.length; i++) {
                var item = document.createElement("a");
                item.className = "list-group-item";
                $(item).css({"font-size": "18px", "color": "black"});
                $(item).hover(function () {
                    $(this).css({"background-color": "gray"});
                }, function () {
                    $(this).css({"background-color": "white"});
                });
                $(item).attr({"href": "/user_alter/" + users[i].id});

                if(users[i].status == 0){
                    item.innerHTML = "管理员：" + users[i].name + "  " + users[i].phone + "  " + users[i].email;
                }else if(users[i].status == 1){
                    item.innerHTML = "用户：" + users[i].name + "  " + users[i].phone + "  " + users[i].email;
                }else{
                    item.innerHTML = "客服：" + users[i].name + "  " + users[i].phone + "  " + users[i].email;
                }

                list_group.appendChild(item);
            }

            $(list_group).css({"width": "800px", "margin-left": "285px", "z-index": "100", "position": "absolute", "top": "50px", "opacity": 0.9});
            var body1 = document.getElementsByTagName("body");
            body1[0].appendChild(list_group);
        }
    });
}

var cpLock = false;
$('#search').on('compositionstart', function () {
    // 输入汉语拼音时锁住搜索框，不进行搜索，或者从汉语拼音转到字母时也可触发
    cpLock = true;
    // console.log('不搜索');
});
$('#search').on('compositionend', function () {
    // 结束汉语拼音输入并生成汉字时，解锁搜索框，进行搜索
    cpLock = false;
    // console.log('汉字搜索');
    search();
});
$('#search').on('input', function () {
    if (!cpLock) {
        // console.log('字母搜索')
        search();
    }
});
$("#search").focusin(function () {
    var input = $(this).val();
    if(input != "")
        search();
});
$('html').click(function(event) {
    // IE支持 event.srcElement ， FF支持 event.target
    var evt = event.srcElement ? event.srcElement : event.target;
    if(evt.tagName == 'A' ) return; // 如果是元素本身，则返回
    $('#list_group').hide(); // 如不是则隐藏元素
});
