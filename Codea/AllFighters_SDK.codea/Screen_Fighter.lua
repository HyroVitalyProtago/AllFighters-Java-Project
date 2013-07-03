Screen_Fighter = class(Screen)

function Screen_Fighter:init(fighter)
    Screen.init(self, "Fighter")
    
    self.fighter = self:loadFighter(fighter)
    
    ------------------------------- Background -----------------------------
    ToolScreen.makeCustomBackground(self)
    ----------------------------------------------------------------------
    
    ------------------------------- Menu top -----------------------------
    ToolScreen.makeMenuTop(self)
    ToolScreen.makeCurrentLocation(self, "Fighter - " .. fighter["name"])
    ToolScreen.makeInfos(self)
    ToolScreen.makePreviousMenuTop(self, "Fighters")
    ----------------------------------------------------------------------
    
end

function Screen_Fighter:start()
    ------------------------------- Menu left -----------------------------
    local spr = image(WIDTH, HEIGHT)
    setContext(spr)
        local gray = 22
        fill(gray, gray, gray)
        strokeWidth(2)
        stroke(0, 0, 0)
        rect(0, 0, spr.width, spr.height)
    setContext()
    
    self.menuLeft = Mesh.makeMesh(spr, {})
    self.menuLeft.pos.x = -spr.width/2
    self.menuLeft.pos.y = spr.height/2
    self.menuLeft.pos.z = 10
    table.insert(self.meshes, self.menuLeft)
    ----------------------------------------------------------------------
    tween(1, self.menuLeft.pos, {x=-WIDTH/5}, tween.easing.cubicInOut)
end

function Screen_Fighter:loadFighter(fighter)
    --[[
    local location = os.getenv("HOME").."/Documents/Dropbox.spritepack/SpriteAllFighters/" .. 
        fighter["directory"] .. ".xml"
    ]]--
    --local xml = XML(XML.fileToString(location))
    -- TODO fighter from Xml
end

function Screen_Fighter:touched(touch)
    if touch.state == BEGAN then -- ENDED
        Screen.touched(self, touch)
        if (self.menuLeft:isTouched(touch)) then
            tween(1, self.menuLeft.pos, {x=-WIDTH/2}, tween.easing.cubicInOut, function()
                self:removeMesh(self.menuLeft)
                manager:setCurrentState(MiniatureToRight(self, Screen_MainMenu()))
            end)
        end
    end
end
