-- AllFighters_SDK

supportedOrientations(LANDSCAPE_ANY)
supportedOrientations(CurrentOrientation)
displayMode(FULLSCREEN)
    
CURRENT_STATE = nil
STATES = {}

function setup()
    touches = {}
    setCurrentState(Screen_MainMenu())
end

function draw()
    
    background(0, 0, 0, 255)
    noFill()
    stroke(255, 255, 255, 255)
    strokeWidth(5)
    font("HelveticaNeue-Light")
    
    if CURRENT_STATE == nil then
        return
    end
    
    CURRENT_STATE:draw()
    if CURRENT_STATE:isEnded() then
        CURRENT_STATE:ended()
    end
    
    for k,touch in pairs(touches) do
        math.randomseed(touch.id)
        fill(math.random(255),math.random(255),math.random(255))
        ellipse(touch.x, touch.y, 100, 100)
    end

end

function setCurrentState(state, start)
    CURRENT_STATE = state
    if start == nil or start then
        state:start()
    end
end

function touched(touch)
    -- _touches(touch)
    if CURRENT_STATE ~= nil then
        CURRENT_STATE:touched(touch)
    end
end

function _touches(touch)
    if touch.state == ENDED then
        touches[touch.id] = nil
    else
        touches[touch.id] = touch
    end
end