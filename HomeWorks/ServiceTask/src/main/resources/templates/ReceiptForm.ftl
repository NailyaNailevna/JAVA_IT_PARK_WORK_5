<#ftl encoding='UTF-8'>
<!doctype html>
<head>
    <meta charset="UTF-8">
    <title>Receipt</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
<#--
    <script>
        function changeStatus(id, status_element) {
            $.ajax({
            type: "POST",
            url: "/receipts/" + id + "?action=change_status",
            success: function (response) {
            status_element.innerHTML = response["state"];
            }
            });
        }
    </script>
-->
</head>
<body>
<div class="form-style-9">
    <div>Рецепт</div>
<#--<fieldset>-->
    <form name="receipt" action="/addReceipt" method="post">

        <input id="typeId" name="typeId" type="hidden" value="5" readonly="readonly"/>
        <input id="signId" name="signId" type="hidden" value="2" readonly="readonly"/>

        <br>
        <label for="series">
            <span>Серия <span class="required">*</span></span>
            <input type="text" id="series" name="series" value=""/>
        </label>

        <label for="num">
            <span>Номер <span class="required">*</span></span>
            <input id="num" name="num" type="text"/>
        </label>

        <label for="issueDt">
            <span>Дата выписки <span class="required">*</span></span>
            <input id="issueDt" name="issueDt" type="date"/>
        </label>
        <br>
        <label for="beginDt">
            <span>Действует с <span class="required">*</span></span>
            <input id="beginDt" name="beginDt" type="date"/>
        </label>
        <label for="endDt">
            <span>по <span class="required">*</span></span>
            <input id="endDt" name="endDt" type="date"/>
        </label>
        <br>
        <label for="patient">
            <span>Пациент <span class="required">*</span></span>
        </label>
        <select id="patient" name="patientId"
                onChange="document.OrderForm.TT.value=document.OrderForm.patientId.options[document.OrderForm.patientId.selectedIndex].text;">
            <option selected disabled hidden style='display: none' value=''></option>
            <#list patients as patient>
                <option value="${patient.id?c}">${patient.fio}</option>
            </#list>
        </select>
        <br>
        <label for="birthDt">
            <span>Дата рождения <span class="required">*</span></span>
            <input id="birthDt" name="birthDt" type="date" value=""/>
        </label>
        <label for="age">
            <span>Возраст </span>
            <input id="age" name="age" type="text" readonly="readonly">
        </label>
        <br>
        <label for="ageCategory">
            <span>Возрастная категория <span class="required">*</span></span>
            <select id="ageCategory" name="ageCategoryId" style="width:15%;"
                <option selected value=''></option>
                <option value="1">Категория I</option>
                <option value="2">Категория II</option>
                <option value="3">Категория III</option>
            </select>
        </label>
        <label for="benefitDefinition">
            <span>Код категории граждан <span class="required">*</span></span>
            <select id="benefitDefinition" name="benefitDefinitionId" style="width:30%;">
                <option selected disabled hidden style='display: none' value=''></option>
                <option value="73">По социальному положению</option>
                <option value="74">По заболеванию</option>
            </select>
        </label>
    <br>
        <label for="diagnosis">
            <span>Диагноз</span>
        </label>
        <#--<input id="diagnosisId" name="diagnosisId" type="search" value="21431" style="width:30%">-->
        <select id="diagnosis" name="diagnosisId" style="width:89%;"
                onChange="document.OrderForm.TT.value=document.OrderForm.diagnosisId.options[document.OrderForm.diagnosisId.selectedIndex].text;">
            <#--<option selected disabled value="null&c"></option>-->
                <option selected value="-1"></option>
        <#list diagnosis as diagnos>
            <option value="${diagnos.id?c}">${diagnos.code}: ${diagnos.name}</option>
        </#list>
        </select>

    <br>
        <label for="kitchen" style="width:84%;">
            <span>Пункт ДМК <span class="required">*</span></span>
        </label>
        <select id="kitchen" name="kitchenId"
                onChange="document.OrderForm.TT.value=document.OrderForm.kitchenId.options[document.OrderForm.kitchenId.selectedIndex].text;">
            <option selected disabled hidden style='display: none' value=''></option>
            <#list kitchens as kitchen>
                <option value="${kitchen.id?c}">${kitchen.name}</option>
            </#list>
        </select>
        <br>
        <label for="clinic">
            <span>МО <span class="required">*</span></span>
        </label>
        <select id="clinic" name="clinicId" style="width:35%;" disabled="disabled">
            <option value="490">Контрольная МО</option>
        </select>
        <input id="clinic" name="clinicId" type="text" value="490" hidden="hidden"/>

        <label for="employeePosition">
            <span>Врач <span class="required">*</span></span>
        </label>
        <select id="employeePosition" style="width:35%;" disabled="disabled">
            <option value="8327">терапевт Башнев М.А.</option>
        </select>
        <input id="employeePositionId" name="employeePositionId" type="text" value="8327" readonly="readonly" hidden="hidden"/>
        <br>
        <input type="submit" value="Сохранить"/>

    </form>
<#--</fieldset>-->

</div>
</body>
</html>