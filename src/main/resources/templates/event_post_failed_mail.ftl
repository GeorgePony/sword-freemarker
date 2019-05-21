<html>

    <body>
        <div style="margin-left: 10%">
            <h2>Dear All:</h2>
            <p>汉高交通事件通过${sender}推送给${receiver}失败,请尽快安排线下处理！</p>
        </div>
        <table border="1" style="margin-left: 10%">
            <thead>
                <tr style="text-align: center">
                    <th width="10%">属性名</th>
                    <th width="80%">属性值</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td style="text-align: center">接收方</td>
                    <td>${receiver}</td>
                </tr>
                <tr>
                    <td style="text-align: center">推送方式</td>
                    <td>${method}</td>
                </tr>
                <tr>
                    <td style="text-align: center">消息内容</td>
                    <td>${content}</td>
                </tr>
            </tbody>
        </table>
    </body>
</html>