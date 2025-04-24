<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>냉장고 재료로 요리 추천</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1 class="text-center my-4">냉장고 재료로 요리 추천</h1>
        <form id="uploadForm" enctype="multipart/form-data">
            <div class="mb-3">
                <label for="imageUpload" class="form-label">이미지 업로드</label>
                <input type="file" class="form-control" id="imageUpload" name="image" accept="image/*" required>
            </div>
            <button type="submit" class="btn btn-primary">업로드</button>
        </form>

        <h3 class="mt-4" id="loadingMessage" style="display:none;">이미지를 분석 중입니다...</h3>

        <div id="result" class="mt-4"></div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        document.getElementById("uploadForm").addEventListener("submit", async (event) => {
            event.preventDefault();

            const formData = new FormData();
            formData.append("image", document.getElementById("imageUpload").files[0]);

            document.getElementById("loadingMessage").style.display = "block";

            const response = await fetch("http://<EC2_PUBLIC_IP>:8000/upload", {
                method: "POST",
                body: formData
            });

            const result = await response.json();
            document.getElementById("loadingMessage").style.display = "none";
            displayResult(result);
        });

        function displayResult(result) {
            const resultDiv = document.getElementById("result");
            resultDiv.innerHTML = "<h4>분석 결과:</h4><ul>";

            result.ingredients.forEach(ingredient => {
                resultDiv.innerHTML += `<li>${ingredient}</li>`;
            });

            resultDiv.innerHTML += "</ul>";
        }
    </script>
</body>
</html>
