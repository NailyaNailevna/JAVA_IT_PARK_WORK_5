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
    <#--<script>-->
        <#--function changeStatus(id, status_element) {-->
            <#--$.ajax({-->
                <#--type: "POST",-->
                <#--url: "/receipts/" + id + "?action=change_status",-->
                <#--success: function (response) {-->
                    <#--status_element.innerHTML = response["state"];-->
                <#--}-->
            <#--});-->
        <#--}-->
    <#--</script>-->
</head>
<body>
<#--<h3>Рецепт</h3>-->
<div class="form-style-9">
    <div>Рецепт</div>
    <#--<fieldset>-->
        <form name="receipt" action="" method="GET">

    <#--<form action="/addReceipt" method="post">-->
        <#--<select class="form-control" id="clinics" name="testOrder">-->
        <#--<@spring.formSingleSelect path, options, attributes/>-->
<#--        <select data-placeholder="Пункт ДМК" class="chosen-select" tabindex="2">
            <#--<option value="">Select Test Order</option>-->
    <#--            <option th:each="kitchen : ${kitchens}"
                        th:value="${kitchen.id}"
                        th:text="${kitchen.name}">
                </option>
            </select>
    -->
<#--</div>-->
<#--<div>-->
        <input id="typeId" name="typeId" type="text" value="5" readonly="readonly"/>
        <input id="signId" name="signId" type="text" value="2" readonly="readonly"/>
        <#--<input id="validityId" name="validityId" type="hidden"/>-->

    <br>
        <label for="series">
            <span>Серия <span class="required">*</span></span>
            <input type="text" id="series" name="series" value=""/>
        </label>
        <#--<input id="series" name="series" type="text"/>-->

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
            <#--<input id="patientId" name="patientId" type="search">-->
        </label>
        <select id="patient">
            <option selected></option>
            <#list patients as patient>
                <option value="${patient.id}">${patient.fio}</option>
            </#list>
        </select>
    <br>
        <label for="birthDt">
            <span>Дата рождения <span class="required">*</span></span>
            <input id="birthDt" name="birthDt" type="date"/>
            <#--value="${patient.birthDate}"-->
        </label>
        <label for="age">
            <span>Возраст </span>
            <input id="age" name="age" type="text" readonly="readonly">
        </label>
    <br>
        <label for="ageCategory">
            <span>Возрастная категория <span class="required">*</span></span>
            <#--<input id="ageCategoryId" name="ageCategoryId" type="search" style="width:35%;">-->
            <select id="ageCategory" style="width:15%;">
                <option selected></option>
                <option value="1">Категория I</option>
                <option value="2">Категория II</option>
                <option value="3">Категория III</option>
            </select>
        </label>
        <label for="benefitDefinition">
            <span>Код категории граждан <span class="required">*</span></span>
            <#--<input id="benefitDefinitionId" name="benefitDefinitionId" type="search" style="width:35%">-->
            <select id="benefitDefinition" style="width:30%;">
                <option selected></option>
                <option value="73">По социальному положению</option>
                <option value="74">По заболеванию</option>
            </select>
        </label>
    <br>
        <label for="diagnosis">
            <span>Диагноз</span>
        </label>
        <select id="diagnosis" style="width:89%;">
            <option selected></option>
            <#list diagnosis as diagnos>
                <option value="${diagnos.id}">${diagnos.code}: ${diagnos.name}</option>
            </#list>
        </select>
    <br>
        <label for="kitchen" style="width:84%;">
            <span>Пункт ДМК <span class="required">*</span></span>
        </label>
        <select id="kitchen">
        <#list kitchens as kitchen>
              <option value="${kitchen.id}">${kitchen.name}</option>
        </#list>
        </select>
    <br>
        <label for="org">
            <span>МО <span class="required">*</span></span>
            <#--<input id="orgId" name="orgId" type="text" value="490" readonly="readonly"/>-->
        </label>
        <select id="org" style="width:35%;" disabled="disabled">
            <option value="490">Контрольная МО</option>
        </select>
        <input id="org.id" name="orgId" type="text" value="490" hidden="hidden"/>

        <label for="employeePosition">
            <span>Врач <span class="required">*</span></span>
        </label>
        <select id="employeePosition" style="width:35%;" disabled="disabled">
            <option value="8327">терапевт Башнев М.А.</option>
        </select>
            <input id="employeePositionId" name="employeePositionId" type="text" value="8327" readonly="readonly" hidden="hidden"/>
    <br>
        <input type="submit" value="Сохранить" />

    </form>
    <#--</fieldset>-->

</div>
</body>
</html>