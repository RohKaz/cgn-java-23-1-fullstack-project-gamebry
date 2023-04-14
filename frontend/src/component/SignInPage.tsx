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
                navigate("/home")
                axios.get("/api/games/new")
                alert("You have successfully logged in!")
            }).catch(() => {
                alert("Invalid username or password");
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
                <Typography variant={"h4"} sx={{textAlign: "center", marginBottom: 3}}>Welcome to GaMeBry! <Games
                    fontSize={"inherit"}/></Typography>

            <Card
                sx={{textAlign: "center", padding: 2, border: 5, borderRadius: 4, marginBottom: 6}}>

                <Typography variant={"h5"} sx={{margin: 2, textAlign: "center"}}>Sign In</Typography>
                <p><AccountBox fontSize={"large"}/></p>
                <TextField
                    sx={{marginBottom: 2}}
                    id={"outlined-basic"}
                    label={"Username"}
                    variant={"outlined"}
                    onChange={e => setUsername(e.currentTarget.value)}/>
                <div>
                    <TextField
                        id={"outlined-basic"}
                        label={"Password"}
                        type={"password"}
                        variant={"outlined"}
                        onChange={e => setPassword(e.currentTarget.value)}/>
                </div>
                <Button sx={{marginTop: 2, marginBottom: 1, alignContent: "center"}} startIcon={<Login/>}
                        variant={"outlined"} size={"small"} onClick={() => handleSignIn(username, password)}>Sign
                    In</Button>
            </Card>
            <Typography sx={{fontSize: 15}}>Don't have an account yet?
                <Button sx={{fontSize: 10, marginLeft: 2}} variant={"outlined"} onClick={() => navigate("/")}>Sign
                    up</Button></Typography>
            <Typography sx={{marginTop: 6}}>Powered by RAWG</Typography>
        </Box>
    );

}