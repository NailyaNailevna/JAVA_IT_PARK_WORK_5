<#ftl encoding='UTF-8'>
<!doctype html>
<head>
    <meta charset="UTF-8">
    <title>Receipts</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <script>
        function deleteReceipt(id) {
            $.ajax({
                type: "POST",
                url: "/receipts/" + id + "?action=delete",
                success: function (response) {
//                    status_element.innerHTML = response["receipt.canceled"];
                    location.reload();
                }
            });
        }
    </script>

</head>
    <body>
    <h3>Журнал рецептов</h3>
    <a href="addReceipt">Создать Рецепт</a>
    <#--<a href="addIssue">Выдать продукты</a>-->
    <br><br>
    <div class="receipts">
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
                <th>
                    Пациент
                </th>
                <th>
                    Дата рождения
                </th>
                <#--<th>-->
                    <#--Возраст-->
                <#--</th>-->
                <th>
                    Пункт ДМК
                </th>
                <th>
                    Врач
                </th>
            </tr>
        <#list receipts as receipt>
            <tr <#if receipt.canceled> style="color:darkgray"</#if>>
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
                <td>
                    <input type="button" value="Удалить" onclick="deleteReceipt(${receipt.id?c})" class="form-style-9 input" style="padding: 4px 8px; margin: -2px;"/>
                </td>
                <#--<td>-->
                    <#--<form action="/receipts/${receipt.id?c}/issues" method="get">-->
                        <#--<input type="submit" value="Выдачи" class="form-style-9 input" style="padding: 4px 8px; margin: -2px;"/>-->
                    <#--</form>-->
                <#--</td>-->
            </tr>
        </#list>
        </table>
    </div>

    <#--<br><br>-->
    <#--<class id="isuues_list">-->

    <#--</class>-->
    </body>
</html>