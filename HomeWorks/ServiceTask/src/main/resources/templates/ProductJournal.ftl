<#ftl encoding='UTF-8'>
<!doctype html>
<head>
    <meta charset="UTF-8">
    <title>Issues</title>
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
    <div class="box-header" style="padding: 10px 10px 0px 0px;">
        <a href="/receipts">
            <button class="form-style-9 input" style="padding: 4px 8px; margin: -2px;"><i
                    class="fa fa-back"></i> К списку рецептов
            </button>
        </a>
    </div>
    <br><br>
    <div class="products">
        <table>
            <tr>
                <th>
                    Дата выдачи
                </th>
                <th>
                    Информация о выдаче
                </th>
                <#--<th>-->
                    <#--Дата 2-->
                <#--</th>-->
            </tr>
            <#list issues as issue>
                <tr>
                    <td>
                        <p id="issueDate">${issue.distributeDt}</p>
                    </td>
                    <td>
                        <p id="distributeInfo">${issue.distributeInfo}</p>
                    </td>
                </tr>
            </#list>
        </table>
    </div>
    </body>
</html>