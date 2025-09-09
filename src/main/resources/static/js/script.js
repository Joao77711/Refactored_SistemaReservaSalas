document.addEventListener("DOMContentLoaded", () => {
    const loginForm = document.getElementById("loginForm");
    if (loginForm) {
        loginForm.addEventListener("submit", async (e) => {
            e.preventDefault();
            const login = document.getElementById("login").value.trim();
            const senha = document.getElementById("senha").value.trim();
            if(!login || !senha){ alert("Preencha login e senha"); return; }
            try{
                const res = await fetch("/api/usuarios/login", {
                    method:"POST", headers:{ "Content-Type":"application/json" },
                    body: JSON.stringify({login, senha})
                });
                if(!res.ok) throw new Error("Credenciais inválidas");
                alert("Login ok!");
            }catch(err){ alert(err.message); }
        });
    }

    const salaForm = document.getElementById("salaForm");
    if (salaForm) {
        salaForm.addEventListener("submit", async (e) => {
            e.preventDefault();
            const nome = document.getElementById("nomeSala").value.trim();
            if(!nome){ alert("Informe o nome da sala"); return; }
            try{
                const res = await fetch("/api/salas", {
                    method:"POST", headers:{ "Content-Type":"application/json" },
                    body: JSON.stringify({nome, capacidade: 10})
                });
                if(!res.ok) throw new Error("Falha ao cadastrar");
                alert("Sala cadastrada!");
            }catch(err){ alert(err.message); }
        });
    }

    const reservaForm = document.getElementById("reservaForm");
    if (reservaForm) {
        reservaForm.addEventListener("submit", async (e) => {
            e.preventDefault();
            const data = document.getElementById("data").value;
            const horaInicio = document.getElementById("horaInicio").value;
            const horaFim = document.getElementById("horaFim").value;
            const salaId = document.getElementById("idSala").value;
            const usuarioId = document.getElementById("idUsuario").value;
            if(!data || !horaInicio || !horaFim || !salaId || !usuarioId){ alert("Preencha todos os campos"); return; }
            try{
                const res = await fetch("/api/reservas", {
                    method:"POST", headers:{ "Content-Type":"application/json" },
                    body: JSON.stringify({data, horaInicio, horaFim, salaId, usuarioId})
                });
                if(!res.ok){
                    const txt = await res.text();
                    throw new Error(txt || "Falha ao cadastrar");
                }
                alert("Reserva cadastrada!");
            }catch(err){ alert(err.message); }
        });
    }
});
