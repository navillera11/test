window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki

    //가볍고 확장 가능하며 종속성이없는 자바 스크립트 HTML 테이블 플러그인
    //jQuery DataTables와 유사 하지만 jQuery 종속성이 없다.
    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }
});
