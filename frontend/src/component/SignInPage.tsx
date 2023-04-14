import {Box, Button, TextField} from "@mui/material";
import Typography from "@mui/material/Typography";
import {AccountBox, Games, Login} from "@mui/icons-material";
import axios from "axios";
import Card from "@mui/material/Card";
import {useNavigate} from "react-router-dom";
import React, {useState} from "react";


export default function SignInPage() {
    const navigate = useNavigate();
    const [username, setUsername] = useState<string>("");
    const [password, setPassword] = useState<string>("");

    const handleSignIn = (username: string, password: string) => {
        axios
            .get("/api/csrf")
            .then(() => axios.post("/api/users/login", {},
                {
                    headers: {
                        Authorization: `Basic ${window.btoa(`${username}:${password}`)}`
                    }
                }).then(() => {
                navigate("/home");
            }).catch((error) => {
                alert(error.response.data.error);
            }))
    };

    return (
        <Box
            sx={{
                display: "flex",
                minHeight: "400",
                maxHeight: "fit-content",
                flexDirection: "row",
                flexWrap: "wrap",
                justifyContent: "center",
                alignItems: "flex-start",
                alignContent: "center",
                border: 1,
                borderColor: "black",
                backgroundColor: "#1f345c",
                textAlign: "left",
                padding: 5,
                color: "white",
            }}
        >
            <header>
                <Typography variant={"h4"} sx={{textAlign: "center", marginBottom: 3}}>Welcome to GaMeBry! <Games
                    fontSize={"inherit"}/></Typography>
            </header>

            <Card
                sx={{textAlign: "center", padding: 2, border: 5, borderRadius: 4, marginBottom: 6, boxShadow: 5}}>

            <Typography variant={"h5"} sx={{margin: 2, textAlign: "center"}}>Sign In</Typography>
                    <p><AccountBox fontSize={"large"}/></p>
                        <TextField
                            sx={{marginBottom: 2}}
                            id={"outlined-basic"}
                            label={"Username"}
                            variant={"outlined"}
                            onChange={e => setUsername(e.currentTarget.value)}/>
                        <TextField
                            id={"outlined-basic"}
                            label={"Password"}
                            type={"password"}
                            variant={"outlined"}
                            onChange={e => setPassword(e.currentTarget.value)}/>

                <Button sx={{marginTop: 2, marginBottom: 1, alignContent: "center"}} startIcon={<Login/>}
                        variant={"outlined"} size={"small"} onClick={() => handleSignIn(username, password)}>Sign
                    In</Button>
            </Card>
            <Typography sx={{fontSize: 15}}>Don't have an account yet?
                <Button sx={{fontSize: 10}} variant={"outlined"} onClick={() => navigate("/")}>Sign
                    up</Button></Typography>
            <Typography sx={{textDecoration: "none", marginTop: 6}}>Powered by RAWG</Typography>
        </Box>
    );

}