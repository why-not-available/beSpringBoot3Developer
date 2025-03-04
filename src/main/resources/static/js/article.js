// 삭제하기
const deleteButton = document.getElementById('delete-btn');

if(deleteButton){
    deleteButton.addEventListener('click', event => {
        let id = document.getElementById('article-id').value;
        console.log("삭제할 ID: ", id);
        fetch(`/api/articles/${id}`, {
            method: 'DELETE'
        })
        .then(() => {
            alert('삭제가 완료되었습니다');
            location.replace('/articles');
        });
    });
}

// 수정하기
const modifyButton = document.getElementById('modify-btn'); //: id가 'modify-btn'인 엘레먼트 조회하기

if(modifyButton){
    //: click 이벤트가 감지되면 수정API 요청
    modifyButton.addEventListener('click', event => {
        let params = new URLSearchParams(location.search);
        let id = params.get('id');

        fetch(`/api/articles/${id}`, {
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            })
        })
        .then(() => {
            alert('수정이 완료되었습니다.');
            location.replace(`/articles/${id}`);
        });
    });
}

// 등록하기
const createButton = document.getElementById("create-btn");

if(createButton){
    createButton.addEventListener("click", (event) => {
        fetch("/api/articles", {
            method: "POST",
            headers:{
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById("content").value,
                content: document.getElementById("content").value,
            }),
        }).then(() => {
            alert("등록 완료되었습니다.");
            location.replace("/articles");
        });
    });
}