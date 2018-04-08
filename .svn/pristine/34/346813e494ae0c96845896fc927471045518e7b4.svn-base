<#--
<textarea name="textarea"></textarea>
-->
<#macro editor
	name value="" height="230"
	fullPage="false" toolbarSet="My"
	label="" noHeight="false" required="false" colspan="" width="100" help="" helpPosition="2" colon=":" hasColon="true"
	maxlength="65535"
	onclick="" ondblclick="" onmousedown="" onmouseup="" onmouseover="" onmousemove="" onmouseout="" onfocus="" onblur="" onkeypress="" onkeydown="" onkeyup="" onselect="" onchange=""
	>
<#include "control.ftl"/><#rt/>
<textarea id="${name}" name="${name}">${value}</textarea>  

<script type="text/javascript">
  MARK="true";
   var editor= UE.getEditor('${name}',{
   		imageUrl:"${base+appBase}/ueditor/upload.do?Type=Image&mark="+MARK ,
   		fileUrl:"${base+appBase}/ueditor/upload.do?Type=File",
   		catcherUrl:"${base+appBase}/ueditor/getRemoteImage.do?Type=Image",
   		imageManagerUrl:"${base+appBase}/ueditor/imageManager.do?picNum=50&insite=false",
   		snapscreenServerUrl:"/snapscreen.svl",
   		wordImageUrl:"${base+appBase}/ueditor/upload.do?Type=File" ,
   		getMovieUrl:"${base+appBase}/ueditor/getmovie.do",
   		videoUrl:"${base+appBase}/ueditor/upload.do;jsessionid="+$.cookie("JSESSIONID")+"?Type=Media"
   });
   //截图快捷键ctrl+shift+A
   editor.addshortcutkey({
        "snapscreen" : "ctrl+shift+65"
    });
</script>
<#include "control-close.ftl"/><#rt/>
</#macro>