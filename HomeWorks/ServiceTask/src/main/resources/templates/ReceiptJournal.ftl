<#ftl encoding='UTF-8'>
<!doctype html>
<head>
    <meta charset="UTF-8">
    <title>Users</title>
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
<div class="names">
    <table>
        <tr>
            <th>
                ID
            </th>
            <th>
                Серия
            </th>
            <th>
                Номер
            </th>
        </tr>
    <#list users as user>
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
        </tr>
    </#list>
    </table>
</div>
</body>
</html>