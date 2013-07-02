Screen_Fighter = class(Screen)

function Screen_Fighter:init(fighter)
    Screen.init(self, "Fighter")
    
    ------------------------------- Background -----------------------------
    ToolScreen.makeCustomBackground(self)
    ----------------------------------------------------------------------
    
    ------------------------------- Menu top -----------------------------
    ToolScreen.makeMenuTop(self)
    ToolScreen.makeCurrentLocation(self, "Fighter - Takeshi Yamamoto")
    ToolScreen.makeInfos(self)
    ----------------------------------------------------------------------
    
end

function Screen_Fighter:start()
end

function Screen_Fighter:touched(touch)
end
