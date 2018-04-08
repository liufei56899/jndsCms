
        var xuanzeArray = new Array();
        var xuanzeTiNumber =1;


        var panduanTiArray =new Array();
        var panduanTiNumber =1;

        var jiandaTiArray =new Array();
        var jiandaTiNumber =1;

        var tiankongTiArray =new Array();
        var tiankongTiNumber =1;     



         $(function(){
            var examinationid =$("#examinationid").val();
            $.ajax({
                url:"/dqjyadmin/jcExamination/queryAnswerpaper.do",
                data:{"examinationid":examinationid},
                cache:false,
                success:function(json){
                  json =eval("("+json+")");
                  console.log(json);
                  if(json.length > 0){
                        var flag =0;  //
                        for(var i =0; i < json.length ;i++){
                            if(json[i].classtype == '1'){//判断是否选择题   1. 选择题
                                    var bianHao =0;
                                    for(var j =0; j < json[i].answers.length ;j++){
                                        if(json[i].answers[j].isright =='1'){
                                            bianHao =j;
                                        }
                                    }
                                    xuanzeArray.push({number:i,bianHao:bianHao});
                                    var data={m:json[i],idnex:["A","B","C","D"],j:i,xuanzeTiNumber:xuanzeTiNumber};
                                    var html=template('choiceQuestion',data);
                                    $("#xuanze").append(html);
                                    xuanzeTiNumber++;
                            }else if(json[i].classtype =='3'){//判断是否为判断提  3. 判读题
                                     panduanTiArray.push(i);
                                     var data={m:json[i],j:i,panduanTiNumber:panduanTiNumber};
                                    var html=template('panduanTi',data);
                                    $("#panduanTi_titi").append(html);
                                    panduanTiNumber++;
                            }else if(json[i].classtype == '4'){//判断是否为判断提  4. 简答题
                                    jiandaTiArray.push(i);
                                    var data ={m:json[i],j:i,jiandaTiNumber:jiandaTiNumber};
                                    var html =template('jiandaTi',data);
                                    $("#jianda_titi").append(html);
                                    jiandaTiNumber++;
                            }else if(json[i].classtype == '2'){
                                    var html ="<dd>"+tiankongTiNumber+".";
                                    var content_ =json[i].content.split('（）');
                                    var daan_    =json[i].answers[0].answer.split(',');
                                    tiankongTiArray.push(daan_);
                                    for(var j =0;j<content_.length-1;j++){
                                        html +=content_[j];
                                        html +="<input type='text' name='tianDaAn_"+tiankongTiNumber+"'  />";
                                    }
                                    html +="<b id='tiankong_biaozhi_"+tiankongTiNumber+"'></b> </dd>";
                                    $("#tiankong_titi").append(html);
                                    tiankongTiNumber++;
                            }
                        }
                        //打印按钮
                        $("#xuanze").append("<a class='bt'         onclick='isXuanZERight()'>提交答案</a>");
                        $("#panduanTi_titi").append("<a class='bt' onclick='ispanduanRight()'>提交答案</a>");
                        $("#tiankong_titi").append("<a class='bt'  onclick='istiankongRight()'>提交答案</a>");
                    }
                }
            });
    });
    function isXuanZERight(){
        var  array =['A','B','C','D'];
        console.log(xuanzeArray);
        for(var i=0; i < xuanzeArray.length;i++){
            var right =$("'input[name=awandRadio_"+xuanzeArray[i].number+"]:checked'").val();
            if(right!=undefined){
                if(right==1){
                    $("#chooseHint_"+xuanzeArray[i].number).css("color","green");
                    $("#chooseHint_"+xuanzeArray[i].number).html("恭喜你，答对了。你真棒！");

                }else{
                    $("#chooseHint_"+xuanzeArray[i].number).css("color","red");
                    $("#chooseHint_"+xuanzeArray[i].number).html("很遗憾，答错了。下次加油！ <font color='green'>正确答案是"+array[xuanzeArray[i].bianHao]+"</font>");
                }
            }else{
                $("#chooseHint_"+xuanzeArray[i].number).css("color","red");
                $("#chooseHint_"+xuanzeArray[i].number).html("很遗憾，答错了。下次加油！<font color='green'>正确答案是"+array[xuanzeArray[i].bianHao]+"</font>");
            }
        }
    }
    function ispanduanRight(){
        for(var i =0;i<panduanTiArray.length;i++){
            var right =$("'input[name=panduRadio_"+panduanTiArray[i]+"]:checked'").val();
             if(right!=undefined){
                if(right !='on'){
                    $("#panduTi_"+panduanTiArray[i]).css("color","green");
                    $("#panduTi_"+panduanTiArray[i]).html("恭喜你，答对了。你真棒！");
                }else{
                    $("#panduTi_"+panduanTiArray[i]).css("color","red");
                    $("#panduTi_"+panduanTiArray[i]).html("很遗憾，答错了。下次加油！");
                }
            }else{
                $("#panduTi_"+panduanTiArray[i]).css("color","red");
                $("#panduTi_"+panduanTiArray[i]).html("很遗憾，答错了。下次加油！");
            }
        }
    }
    function isjiandaTiRight(flag){
            $("#daan_"+flag).css("display","block");
    }
    function isclearDaan(flag){
            $("#jiandaTextarea_"+flag).val("");
    }
    function istiankongRight(){
            var numFlag =0;
            $("#tishi dl").html("");
            console.log(tiankongTiNumber);
            for(var i=0;i<tiankongTiNumber-1;i++){

                    var tiankongDaan_ =document.getElementsByName("tianDaAn_"+(i+1));
                    for(var j=0;j <tiankongDaan_.length;j++){
                        if(tiankongDaan_[j].value!=''){
                            console.log(tiankongDaan_[j].value);
                            var arr =tiankongTiArray[i];
                            if(tiankongDaan_[j].value ==arr[j]){
                                    numFlag++;
                            }
                            if(numFlag == arr.length){
                                            $("#tiankong_biaozhi_"+(i+1)).css("color","green");
                                            $("#tiankong_biaozhi_"+(i+1)).html("恭喜你，答对了。你真棒！");
                            }else{
                                            $("#tiankong_biaozhi_"+(i+1)).css("color","red");
                                            $("#tiankong_biaozhi_"+(i+1)).html("很遗憾，答错了。下次加油！");
                            }
                        }else{
                                            $("#tiankong_biaozhi_"+(i+1)).css("color","red");
                                            $("#tiankong_biaozhi_"+(i+1)).html("很遗憾，答错了。下次加油！");
                        }
                    }
                    numFlag=0;  
            }
            var html ="  <font size='4'>答案：</font>";
            for(var i=0;i<tiankongTiNumber-1;i++){
                    html +="<dd>"+(i+1)+". ";
                for(var j=0;j <tiankongTiArray[i].length;j++){
                     var arr =tiankongTiArray[i];
                     html += arr[j]+"  ";
                }
                html +="<dd/>";
                $("#tishi dl").append(html);
                html="";
            }

    }


