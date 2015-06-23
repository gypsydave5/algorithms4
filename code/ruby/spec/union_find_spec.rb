require 'union-find'

describe 'My first pass at UF' do
  it 'can create unions and find connections' do
    qf = UF.new 20
    qf.union 5, 10
    expect(qf.connected? 5, 10).to be true
    expect(qf.connected? 5, 6).to be false
  end
end