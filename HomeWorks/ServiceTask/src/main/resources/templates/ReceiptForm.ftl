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
<h3>Рецепт</h3>
<div class="receipt">
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
        Серия <input id="series" name="series" type="text"/>
        Номер <input id="num" name="num" type="text"/>

        Дата выписки <input id="issueDt" name="issueDt" type="date"/>
    <br>
    <br>
        Действует с <input id="beginDt" name="beginDt" type="date"/>
        по <input id="endDt" name="endDt" type="date"/>
    <br>
    <br>
        Пациент <input id="patientId" name="patientId" type="text">
    <br>
    <br>
        Дата рождения <input id="birthDt" name="birthDt" type="date"/>
        Возраст <input id="age" name="age" type="text" readonly="readonly">
<#--    <br>
    <br>
        Возраст <input id="age" name="age" type="text" readonly="readonly">
-->
    <br>
    <br>
        Возрастная категория <input id="ageCategoryId" name="ageCategoryId" type="text">
        Код категории граждан <input id="benefitDefinitionId" name="benefitDefinitionId" type="text">
    <br>
    <br>
        Диагноз <input id="diagnosisId" name="diagnosisId" type="text">
    <br>
    <br>
        Пункт ДМК <input id="kitchen" name="kitchen" type="text"/>
    <br>
    <br>
        МО <input id="orgId" name="orgId" type="text" value="490" readonly="readonly"/>
        Врач <input id="employeePositionId" name="employeePositionId" type="text" value="8327" readonly="readonly"/>

        <#--<input id="kitchen" type="text" name="kitchen"  size="40" list="kitchens" />-->
        <#--<#list kitchens as kitchen>-->
            <#--<input type="test" name="${kitchen.name}" value="${kitchen.id}" />-->
        <#--</#list>-->
    <#--<#list kitchens as kitchen>-->
        <#--<tr>-->
            <#--<td>-->
                <#--<p id="user_id">${kitchen.id}</p>-->
            <#--</td>-->
            <#--<td>-->
            <#--${kitchen.login}-->
            <#--</td>-->
        <#--</tr>-->
    <#--</#list>-->

        <#--<datalist id="kitchens" kitchens as kitchen>-->
            <#--<c:forEach var="row" items="${kitchens}">-->
                <#--<option value="${kitchen.id}">${kitchen.name}</option>-->
            <#--</c:forEach>-->
            <#--<option value="Canada">-->
            <#--<option value="Germany">-->
            <#--<option value="France">-->
            <#--<option value="United Kingdom">-->
            <#--<option value="United States">-->
        <#--</datalist>-->
    <br>
    <br>
        <input type="submit" value="Сохранить" />

    </form>
    <#--</fieldset>-->

</div>
</body>
</html>