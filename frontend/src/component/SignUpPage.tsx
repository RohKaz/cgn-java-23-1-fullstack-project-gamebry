import {Link, useNavigate} from "react-router-dom";
import axios from "axios";
import React, {useState} from "react";
import {Box, Button, TextField} from "@mui/material";
import Typography from "@mui/material/Typography";
import Card from "@mui/material/Card";
import {Games, Login} from "@mui/icons-material";
import Cookies from "js-cookie";


export default function SignUpPage() {

    const navigate = useNavigate();
    const [username, setUsername] = useState<string>("");
    const [password, setPassword] = useState<string>("");

    const handleSignUp = (username: string, password: string) => {
        axios
            .get("/api/csrf")
            .then(() => axios.post("/api/users", {username, password},
                {
                    headers: {
                        "X-XSRF-TOKEN": Cookies.get("XSRF-TOKEN")
                    }
                })
                .then(() => {
                    navigate("/sign-in");
                })
                .catch((error) => {
                    alert(error.response.data.message);
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
                    sx={{textAlign: "center", padding: 2, border: 5, borderRadius: 4, marginBottom: 10, boxShadow: 5}}>
                    <div>
                        <Typography variant={"h5"} sx={{margin: 2, textAlign: "center"}}>Sign Up</Typography>
                        <label>
                            <TextField
                                sx={{marginBottom: 2}}
                                id={"outlined-basic"}
                                label={"Username"}
                                variant={"outlined"}
                                onChange={e => setUsername(e.currentTarget.value)}/>
                        </label>
                    </div>

                    <div>
                        <label>
                            <TextField
                                id={"outlined-basic"}
                                label={"Password"}
                                variant={"outlined"}
                                onChange={e => setPassword(e.currentTarget.value)}/>
                        </label>
                    </div>
                    <Button sx={{
                        marginTop: 2,
                        marginBottom: 3,
                        alignContent: "center"
                    }}
                            onClick={() => handleSignUp(username, password)}
                            variant={"outlined"}
                            size={"small"}
                    >Sign Up</Button>

                    <Typography>Already a user? Then log in with your account!</Typography>
                    <Link to={"/sign-in"}>
                        <Button sx={{marginTop: 2, marginBottom: 1, alignContent: "center"}} startIcon={<Login/>}
                                variant={"outlined"} size={"small"}>Sign In</Button>
                    </Link>
                </Card>
            <Typography sx={{textDecoration: "none"}}>Powered by RAWG</Typography>
        </Box>
    );
    
}