<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>URL 단축 서비스</title>
</head>
<body>
    <h2>URL 입력</h2>
    <form id="url-input-form">
        <label for="url">단축시킬 URL:</label>
        <input type="text" id="url" name="url" required><br><br>

        <button type="submit">실행</button>
    </form>

    <h3>단축된 URL:</h3>
    <a id="short-url" href="#" target="_blank"></a>

    <script>
        document.getElementById('url-input-form').addEventListener('submit', function(event) {
            event.preventDefault();

            const url = document.getElementById('url').value;

            fetch('/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'text/plain'
                },
                body: url
            })
            .then(response => response.text())
            .then(shortUrl => {
                document.getElementById('short-url').innerText = "localhost:8080/" + shortUrl;
                document.getElementById('short-url').href = "http://localhost:8080/" + shortUrl;
            })
            .catch(error => {
                console.error('Error:', error);
            });
        });
    </script>
</body>
</html>