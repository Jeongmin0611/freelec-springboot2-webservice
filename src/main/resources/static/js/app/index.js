const main = {
    init : function() { //()=> 와 function() 이랑 차이점 공부해야 됨. ()=> 쓸 때 this 차이?
        const _this = this; //let, const 는 block 스코프라 같은 중괄호 안에서만 인식됨.
        $('#btn-save').on('click', function() {
            _this.save();
        });
    },
    save : function() {
        var data = { //var는 스코프 상관없이 다 됨, 중복선언도 가능.
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
};
main.init();

/*
    브라우져의 스코프는 공용공간으로 쓰이기 때문에 나중에 로딩된 init, save가 먼저 로딩된 js의 function을 덮어쓰게 됩니다.
    여러사람이 참여하는 프로젝트에서는 중복된 함수 이름은 자주 발생할 수 있다.
    이런 문제를 피하기 위해 index.js 만의 유효범위(스코프)를 만들어 사용한다.
    방법은 var index 라는 객체를 만들어 해당 객체에서 필요한 모든 function을 선언하는 것.
    이렇게 하면 index 객체안에서만 function이 유효하기 때문에 다른 js와 겹칠 위험이 사라집니다.
*/