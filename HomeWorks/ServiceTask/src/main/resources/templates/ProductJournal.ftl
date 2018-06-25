<#ftl encoding='UTF-8'>
<!doctype html>
<head>
    <meta charset="UTF-8">
    <title>Products</title>
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
    <h3>Журнал отпущенной продукции</h3>
    <#--<a href="addReceipt">Создать Рецепт</a>-->
    <br><br>
    <div class="products">
        <table>
            <tr>
                <th>
                    Продукт
                </th>
                <th>
                    Дата 1
                </th>
                <th>
                    Дата 2
                </th>
                <th>
                    Дата 3
                </th>
                <th>
                    Дата 4
                </th>
                <th>
                    Дата 5
                </th>
                <th>
                    Дата 6
                </th>
                <#--<th>-->
                    <#--Врач-->
                <#--</th>-->
            </tr>
        <#list products as product>
            <tr>
                <td>
                    <p id="receipt_id">${receipt.id}</p>
                </td>
                <td>
                    ${receipt.series}
                </td>
                <td>
                    <p id="num">${receipt.num}</p>
                </td>
                <td>
                    ${receipt.patientFio}
                </td>
                <td>
                    ${receipt.birthDate}
                </td>
                <#--<td>-->
                    <#--${receipt.age}-->
                <#--</td>-->
                <td>
                    ${receipt.kitchenName}
                </td>
                <td>
                    ${receipt.emplPosName}
                </td>
            </tr>
        </#list>
        </table>
    </div>
    </body>
</html>